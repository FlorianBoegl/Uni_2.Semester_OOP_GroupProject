package project.articles;

import java.util.Objects;

/**
 * Base class for hazardous materials
 * @author Ruf, Lukas
 */
public abstract class HazardBase extends Article {
    private String hazard;

    /**
     * Get the hazard level of an object
     * @return a String representing the hazard level
     */
    public String getHazard() {
        return hazard;
    }

    /**
     * Method to set hazard level of an object
     * @param hazard the hazard level
     */
    public void setHazard(String hazard) {
        this.hazard = hazard;
    }

    /**
     * HazardBase equals object with the same hazard level
     * @param obj
     * @return boolean showing equivalence between classes
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof HazardBase)) return false;
        return ((HazardBase) obj).getHazard().equals(this.getHazard());
    }

    /**
     * HazardBase's custom hashCode method
     * TODO: refactor this
     * @return int hashCode of the Object
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getName(), this.getAvailability(), this.getType(), this.getHazard());
    }


}
