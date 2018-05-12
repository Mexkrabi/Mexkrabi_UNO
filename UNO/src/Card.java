public class Card {

    /**
     * total cards: 108
     * Link ofr download: https://opengameart.org/content/uno
     */
    private int id;
    private String color;
    private int value;
    private boolean isSpecial;
    //important to check if card is in the deck (to avoid duplicates)
    private boolean mixedIntoDeck;

    /**
     * Builder for default values
     * Link: https://stackoverflow.com/questions/24573918/how-to-write-a-java-constructor-for-variable-number-of-arguments-of-different-ty?noredirect=1&lq=1
     */
/*
    // not needed anymore, but good to know
     public static class Builder {
            //default values
            private String color = "red";
            private int value = 1;
            private boolean isSpecial = false;
            private int id = 1000;

            public Builder withColor(String color) {
                this.color = color;
                return this;
            }
            public Builder withValue(int value) {
                this.value = value;
                return this;
            }
            public Builder withIsSpecial(boolean isSpecial) {
                this.isSpecial = isSpecial;
                return this;
            }
            public Builder withId(int id) {
                this.id = id;
                return this;
            }

            public Card build() {
                return new Card(id, color, value, isSpecial);
            }
        }
*/

    public Card(int id, String color, int value, boolean isSpecial) {

        //DEFAULT VALUES TEST
/*
        if(color==null) {
            this.color = "red";
        } else if(value==null) {
            this.value = 1;
        } else if(isSpecial==null) {
            this.isSpecial = false;
        }
*/
        this.id = id;
        if( color.equals("red") ||
            color.equals("yellow") ||
            color.equals("green") ||
            color.equals("blue") ||
            color.equals("black")
            ) {
            this.color = color;
        } else {
            System.out.println("Error: color not found. Please inset another color.");
        }
        this.value = value;
        this.isSpecial = isSpecial;
        mixedIntoDeck = false;

        System.out.println("Card with ID: " + getId() + " created");
    }

    public void setDefaultValues() {
        if (id >= 100 && id <= 103) {
            setColor("balck");
            System.out.println("Card with ID " + id + " succesfully reset!");
        }
        if (id >= 104 && id <= 107) {
            setColor("black");
            System.out.println("Card with ID " + id + " succesfully reset!");
        }
        else {
            System.out.println("Nothing to change on this card! Card ID: " + id);
        }
    }

    /**
     * Getters & Setters
     */
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return this.color;
    }
    public void setColor(String color) {
        if( color.equals("red") ||
            color.equals("yellow") ||
            color.equals("green") ||
            color.equals("blue") ||
            color.equals("black")
            ) {
            this.color = color;
        } else {
            System.out.println("Error: color not found. Please inset another color.");
        }
    }

    public int getValue() {
        return this.value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    public boolean isIsSpecial() {
        return this.isSpecial;
    }
    public void setIsSpecial(boolean isSpecial) {
        this.isSpecial = isSpecial;
    }

    public boolean isMixedIntoDeck() {
        return mixedIntoDeck;
    }
    public void setMixedIntoDeck(boolean mixedIntoDeck) {
        this.mixedIntoDeck = mixedIntoDeck;
    }
}
