package wootz;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@ToString
public class MLModel {
    private String name;
    private List<Layer> layerList;
    private final Map<String, Map<String, Layer>> layerLookup;
    private int layerIndex;

    public MLModel() {
        layerList = new ArrayList<Layer>();
        layerLookup = new HashMap<String, Map<String, Layer>>();
        layerIndex = 0;
    }

    public void addLayer(Layer layer) {

        layer.setLayerIndex(layerIndex++);
        layerList.add(layer);

        String name = layer.getName();
        if (name == null) return;
        String includePhase = layer.getAttr("include.phase");
        includePhase = (includePhase == null) ? "" : includePhase;

        if (layerLookup.containsKey(name)) {
            layerLookup.get(name).put(includePhase, layer);
        } else {
            HashMap map = new HashMap();
            map.put(includePhase, layer);
            layerLookup.put(name, map);
        }

        String type = layer.getAttr("type");
        Config config = Config.getInstance();
        if (type.equals("Data") || config.getCustomDataLayers().contains(type)) {
            layer.setKind(Layer.Kind.DATA);
        } else if (type.toLowerCase().endsWith("loss")) {
            layer.setKind(Layer.Kind.LOSS);
        } else {
            layer.setKind(Layer.Kind.INTERMEDIATE);
        }
    }

    public List<Layer> getDataLayers() {
        List<Layer> ret = new ArrayList<Layer>();

        for (Layer layer : layerList) {
            if (layer.getKind() == Layer.Kind.DATA) {
                ret.add(layer);
            }
        }
        return ret;
    }

    public List<Layer> getNonDataLayers() {
        List<Layer> ret = new ArrayList<Layer>();

        for (Layer layer : layerList) {
            if (layer.getKind() != Layer.Kind.DATA) {
                ret.add(layer);
            }
        }
        return ret;
    }
}
