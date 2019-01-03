package homework4;


public class Bank<V extends Asset> {
    private final String addr;
    private Asset assets[];


    public Bank(String addr) {
        this.addr = addr;
    }


    public void withdraw(long amount, String title) {
        for (int i = 0; i < assets.length; i++) {
            if (assets[i].getClass().getSimpleName().equals(title)) {
                assets[i].setQuantity(assets[i].getQuantity() - amount);
                break;
            }
        }
    }


    public void put(V value) {
            if (assets == null) {
                this.add(value);
                return;
            }

            for (int i = 0; i < assets.length; i++) {
                if (assets[i].getClass().getSimpleName().equals(value.getClass().getSimpleName())) {
                    assets[i].setQuantity(assets[i].getQuantity() + value.getQuantity());
                    return;
                }
            }
            this.add(value);
    }


    private void add(V newValue) {
        if (assets != null) {
            int length = this.assets.length;
            Asset[] buff = new Asset[length + 1];

            for (int i = 0; i < length; i++)
                buff[i] = this.assets[i];

            buff[length] = newValue;
            this.assets = buff;
        }
        else {
            assets = new Asset[1];
            assets[0] = newValue;
        }

        System.out.println("added new Asset: " + newValue.getClass().getSimpleName());
    }

    public Asset[] getAssets() {
        return assets;
    }

    public String getAddr() {
        return addr;
    }

    public void printBank() {
        for (Asset a : assets) {
            System.out.println(a.getQuantity() + " of " + a.getClass().getSimpleName());
        }
    }

}
