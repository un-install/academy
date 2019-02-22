package lesson20.ProxyPizza;

import lesson20.MamaMia.Peperony;
import lesson20.Pizza;

public class ProxyPeperony extends Pizza {
    private Peperony proxy;

    public ProxyPeperony(float radius) {
        super(radius);
        proxy = null;
    }

    @Override
    public float cutDaPeace() {
        if(proxy == null){
            return super.getWeight()/8;
        }
        return proxy.cutDaPeace();
    }

    @Override
    public void addMoreCheeze() {
        if (proxy == null){
            System.out.println("proxy object init");
            proxy = new Peperony(super.getRadius());
        }
        proxy.addMoreCheeze();
    }


}
