package product;

public class Table {
    private boolean occupied;

    public Table(){
        this.occupied = false;
    }


    public boolean isOccupied(){
        return occupied == true;
    }

    public void bookATable(){
        occupied = true;

    }

    public void release(Table table){
        occupied = false;
    }


}
