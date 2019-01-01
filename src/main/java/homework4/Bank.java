package homework4;

import java.util.HashMap;

public class Bank<Integer, V extends Asset> extends HashMap<Integer, V> {
    public final String addr;
    V asset;

    public Bank (String addr){
        this.addr = addr;
    }

    public void withdraw (Integer id, long amount) {
        if (this.isUser(id)) {
            asset = super.get(id);
            asset.setQuantity(super.get(id).getQuantity() - amount);
            super.put(id, asset);
        }
    }

    public void  add (Integer id, long amount) {
        if (this.isUser(id)) {
            asset = super.get(id);
            asset.setQuantity(super.get(id).getQuantity() + amount);
            super.put(id, asset);
        }
    }

    public void toZero (Integer id) {
        if (this.isUser(id)) {
            asset = super.get(id);
            asset.setQuantity(0);
            super.put(id, asset);
        }
    }

    public <K> boolean isUser (K id){
        return super.containsKey(id);
    }
}
