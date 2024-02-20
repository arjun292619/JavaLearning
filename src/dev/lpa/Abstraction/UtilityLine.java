package dev.lpa.Abstraction;

enum UtilityType {
    ELECTRICAL, FIBER_OPTIC, GAS, WATERLINE, TUNNEL
}

public class UtilityLine implements Mappable {
    private String name;
    private UtilityType utilityType;

    public UtilityLine(String name, UtilityType utilityType) {
        this.name = name;
        this.utilityType = utilityType;
    }

    @Override
    public String getLabel() {
        return this.name + " (" + utilityType + ")";
    }

    @Override
    public String getMarker() {
        return switch (this.utilityType) {
            case ELECTRICAL -> Color.RED + " " + LineMarker.DASHED;
            case GAS -> Color.ORANGE + " " + LineMarker.SOLID;
            case WATERLINE -> Color.BLUE + " " + LineMarker.SOLID;
            case FIBER_OPTIC -> Color.GREEN + " " + LineMarker.DOTTED;
            default -> Color.BLACK + " " + LineMarker.SOLID;
        };
    }

    @Override
    public Geometry getShape() {
        return Geometry.LINE;
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + """
                "name": "%s", "utility": "%s" """.formatted(name, utilityType);
    }
}
