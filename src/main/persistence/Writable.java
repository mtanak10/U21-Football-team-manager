package persistence;

import org.json.JSONObject;

// interfaces that allows toJson to be used
public interface Writable {
    // Effects: returns this as a JSON Object

    JSONObject toJson();

}
