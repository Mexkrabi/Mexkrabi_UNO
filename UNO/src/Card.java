public class Card {

    private int id;
    private String color;
    private int value;
    private boolean wildCard;

    public Card(int id) {
        if(id < 0 || id > 107){
            throw new IllegalArgumentException("parameter 'id' must be between 0 and 107");
        }
//normal cards  (with 0)
        if(id >= 0 && id <= 9) {
            setId(id);
            setValue(id);
            setColor("red");
            setWildCard(false);
        }
        if(id >= 10 && id <= 19) {
            setId(id);
            setValue(id-10);
            setColor("yellow");
            setWildCard(false);
        }
        if(id >= 20 && id <= 29) {
            setId(id);
            setValue(id-20);
            setColor("green");
            setWildCard(false);
        }
        if(id >= 30 && id <= 39) {
            setId(id);
            setValue(id-30);
            setColor("blue");
            setWildCard(false);
        }
//normal cards (without 0)
        if(id >= 40 && id <= 48) {
            setId(id);
            setValue(id-39);
            setColor("red");
            setWildCard(false);
        }
        if(id >= 49 && id <= 57) {
            setId(id);
            setValue(id-48);
            setColor("yellow");
            setWildCard(false);
        }
        if(id >= 58 && id <= 66) {
            setId(id);
            setValue(id-57);
            setColor("green");
            setWildCard(false);
        }
        if(id >= 67 && id <= 75) {
            setId(id);
            setValue(id-66);
            setColor("blue");
            setWildCard(false);
        }
//skip cards
        if(id >= 76 && id <=83) {
            setId(id);
            setValue(10);
            setWildCard(false);
            switch (id) {
                case 76:
                    setColor("red");
                    break;
                case 77:
                    setColor("red");
                    break;
                case 78:
                    setColor("yellow");
                    break;
                case 79:
                    setColor("yellow");
                    break;
                case 80:
                    setColor("green");
                    break;
                case 81:
                    setColor("green");
                    break;
                case 82:
                    setColor("blue");
                    break;
                case 83:
                    setColor("blue");
                    break;
            }
        }
//reverse cards
        if(id >= 84 && id <=91) {
            setId(id);
            setValue(11);
            setWildCard(false);
            switch (id) {
                case 84:
                    setColor("red");
                    break;
                case 85:
                    setColor("red");
                    break;
                case 86:
                    setColor("yellow");
                    break;
                case 87:
                    setColor("yellow");
                    break;
                case 88:
                    setColor("green");
                    break;
                case 89:
                    setColor("green");
                    break;
                case 90:
                    setColor("blue");
                    break;
                case 91:
                    setColor("blue");
                    break;
            }
        }
//+2 cards
        if(id >= 92 && id <=99) {
            setId(id);
            setValue(12);
            setWildCard(false);
            switch (id) {
                case 92:
                    setColor("red");
                    break;
                case 93:
                    setColor("red");
                    break;
                case 94:
                    setColor("yellow");
                    break;
                case 95:
                    setColor("yellow");
                    break;
                case 96:
                    setColor("green");
                    break;
                case 97:
                    setColor("green");
                    break;
                case 98:
                    setColor("blue");
                    break;
                case 99:
                    setColor("blue");
                    break;
            }
        }
//wild cards
        if(id >= 100 && id <= 107) {
            setId(id);
            setColor("black");
            setWildCard(true);
    //choose cards
            if(id >= 100 && id <= 103) {
                setValue(13);
            }
    //+4 cards
            if(id >= 104 && id <= 107) {
                setValue(14);
            }
        }
    }

    //Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        if(color.equals("red") || color.equals("yellow") || color.equals("green") || color.equals("blue") || color.equals("black")) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("This color cannot be added, please choose between 'red', 'yellow', 'green', 'blue' and 'black'");
        }
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    public boolean isWildCard() {
        return wildCard;
    }
    public void setWildCard(boolean wildCard) {
        this.wildCard = wildCard;
    }
}
