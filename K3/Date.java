class Date {
    // attributes
    int day;    // 1-31
    int month;  // 1-12
    int year;
    
    // constructor
    Date(int d, int m, int y) {
        day   = d;
        month = m;
        year  = y;
    }
    
    public String toString() {
        return day + "." + month + "." + year;
    }
    
    public static void main(String args[]) {
        Date d = new Date(1,4,2024);
        System.out.println("d = " + d);
    }
}