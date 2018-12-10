package wootz;

import lombok.Data;
import lombok.ToString;

import java.util.*;

@Data
@ToString
public class MLModel {
    private String name;
    private List<Layer> layerList;
    private final Map<String, Layer> layerLookup;
    private int layerIndex;

    public MLModel() {
        layerList = new ArrayList<Layer>();
        layerLookup = new HashMap<String, Layer>();
        layerIndex = 0;
    }

    public void addLayer(Layer layer) {

        layer.setLayerIndex(layerIndex++);
        layerList.add(layer);

        String name = layer.getName();
        if (name == null) return;

        String type = layer.getAttr("type");
        Config config = Config.getInstance();
        if (type.equals("Data") || config.getCustomDataLayers().contains(type)) {
            layer.setKind(Layer.Kind.DATA);
        } else if (type.toLowerCase().endsWith("loss")) {
            layer.setKind(Layer.Kind.LOSS);
        } else {
            layer.setKind(Layer.Kind.INTERMEDIATE);
        }

        layerLookup.put(name, layer);
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
            if (layer.getKind() != null && layer.getKind() != Layer.Kind.DATA) {
                ret.add(layer);
            }
        }
        return ret;
    }

    public List<Layer> reOrderLayers(List<Layer> currentLayers){
        Set<String> layerDone = new HashSet<>();
        List<Layer> newOrderedLayers = new ArrayList<>();
        String firstLayer = "";
        for (Layer layer: currentLayers){
            String layerName = layer.getName();
            if (layerName == null){
                newOrderedLayers.add(layer);
            }
            if (layerName != null && layer.getTop() != null && layerName.equals(layer.getTop())){
                firstLayer = layerName;
                break;
            }
        }
        if (firstLayer.equals("")){
            return layerList;
        }
        layerDone.add(firstLayer);
        if (layerLookup.containsKey(firstLayer)) {
            newOrderedLayers.add(layerLookup.get(firstLayer));
        }
        for (Layer layer: currentLayers){
            String layerName = layer.getName();
            if (layerName == null){
                continue;
            }
            if (layerDone.contains(layerName)){
                continue;
            }
            List<String> bottoms = layer.getBottoms();
            if (bottoms != null) {
                for (String bottom : bottoms) {
                    if (layerDone.contains(bottom)){
                        continue;
                    }
                    if (layerLookup.containsKey(bottom)) {
                        newOrderedLayers.add(layerLookup.get(bottom));
                        layerDone.add(bottom);
                    }
                }
            }
            layerDone.add(layerName);
            newOrderedLayers.add(layer);
        }
        return  newOrderedLayers;
    }

    public void setLayerList(List<Layer> layerList){
        this.layerList = layerList;
    }
}

