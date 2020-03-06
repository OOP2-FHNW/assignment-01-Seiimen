package portfolio;

import portfolio.investments.Investment;
import portfolio.investments.Share;

import java.util.ArrayList;
import java.util.List;

public class Portfolio<T extends Investment> {
    //TODO Complete this implementation and make it generic

    private List<T> Shares = new ArrayList<>();

    public void buy(T s) {
        if (Shares.contains(s)) {
            for (T share : Shares) {
                if (share.equals(s)) {
                    double counter = share.getCount() + s.getCount();
                    share.setCount(counter);
                }
            }
        } else {
            Shares.add(s);
        }
    }

    public void sell(String n, int amnt) {
        for(T s:Shares){
            if (s.getTitel().equals(n)){
                double counter = s.getCount();
                counter -= amnt;
                if(counter < 1){
                    s.setCount(counter);
                    Shares.remove(s);
                } else {
                    s.setCount(counter);
                }
                break;
            }
        }
    }

    public boolean contains(T s){
        boolean check = false;
        if (Shares.contains(s)) {
            check = true;
        }

        return check;
    }

    public Object getShare(String n){
        for(T s:Shares){
            if (s.getTitel().equals(n)){
                return s;
            }
        }
        return null;
    }



}
