package wootz;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@ToString
public class Layer {
    private String name;
    private int layerIndex;
    private String prototxt;
    private Kind kind;
    private final List<String> bottoms;
    private final List<String> tops;
    private List<Map<String, String>> params;
    private Map<String, List<String>> attr;

    public Layer() {
        bottoms = new ArrayList<String>();
        tops = new ArrayList<String>();
        attr = new HashMap<String, List<String>>();
        params = new ArrayList<Map<String, String>>();
    }

    public Layer(int layerIndex) {
        this();
        this.layerIndex = layerIndex;
    }

    public void addAttr(String key, String value) {
        List<String> list = attr.get(key);
        if (list == null) {
            list = new ArrayList<String>();
            list.add(value);
            attr.put(key, list);
        } else {
            list.add(value);
        }
    }

    public String getAttr(String key) {
        List<String> list = attr.get(key);
        if (list == null) {
            return null;
        }

        return list.get(0);
    }

    public String getAttr(String key, String defaultValue) {
        String attr = getAttr(key);
        return attr != null ? attr : defaultValue;
    }

    public boolean hasAttr(String key) {
        return attr.containsKey(key);
    }

    public boolean attrEquals(String key, String value) {
        if (!attr.containsKey(key)) {
            return false;
        }
        return getAttr(key).equals(value);
    }

    public List<String> getAttrList(String key) {
        return attr.get(key);
    }

    public void addTop(String top) {
        tops.add(top);
    }

    public void addBottom(String bottom) {
        bottoms.add(bottom);
    }

    public String getBottom() {
        return bottoms.size() > 0 ? bottoms.get(0) : null;
    }

    public String getType() {
        if (!attr.containsKey("type")){
            return "Default";
        }
        return attr.get("type").get(0);
    }

    public String getTop() {
        return tops.size() > 0 ? tops.get(0) : null;
    }

    public enum Kind {
        DATA, INTERMEDIATE, LOSS;
    }
}
