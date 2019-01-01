package homework4;

import java.util.HashMap;

public class Bank<Integer, V extends Asset> {
    private final String addr;
    private V asset;
    private HashMap<Integer, V> map = new HashMap<>();

    public Bank (String addr){
        this.addr = addr;
    }

    public void withdraw (Integer id, long amount) {
        if (this.isUser(id)) {
            asset = map.get(id);
            asset.setQuantity(map.get(id).getQuantity() - amount);
            map.put(id, asset);
        }
    }

    public void  add (Integer id, long amount) {
        if (this.isUser(id)) {
            asset = map.get(id);
            asset.setQuantity(map.get(id).getQuantity() + amount);
            map.put(id, asset);
        }
    }

    public void toZero (Integer id) {
        if (this.isUser(id)) {
            asset = map.get(id);
            asset.setQuantity(0);
            map.put(id, asset);
        }
    }

    public void put (Integer kay, V value) {
        this.map.put(kay, value);
    }

    public V get (Integer key) {
        return this.map.get(key);
    }

    public boolean isUser (Integer id){
        return map.containsKey(id);
    }

    public void printBank () {
        this.map.forEach((k, v) -> System.out.println("account id: " + k + " balance: " + v.getQuantity() + " of " + v.getClass().getSimpleName()));
    }
}
