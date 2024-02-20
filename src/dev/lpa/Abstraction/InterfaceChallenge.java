package dev.lpa.Abstraction;

import java.util.ArrayList;
import java.util.List;

public class InterfaceChallenge {
    public static void main(String[] args) {
        List<Mappable> mappables = new ArrayList<>();
        mappables.add(new Building("Statue of Liberty", UsageType.TOURISM));
        mappables.add(new Building("Met Stadium", UsageType.SPORTS));
        mappables.add(new Building("Madison Square Garden", UsageType.ENTERTAINMENT));
        mappables.add(new UtilityLine("Lincoln Tunnel", UtilityType.TUNNEL));
        mappables.add(new UtilityLine("Hudson River", UtilityType.WATERLINE));

        for (Mappable m : mappables) {
            Mappable.mapIt(m);
        }
    }
}
