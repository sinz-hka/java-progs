class CalendarDate {
    // attributes
    int day;    // 1-31
    int month;  // 1-12
    int year;
    
    // constructor
    CalendarDate(int d, int m, int y) {
        day   = d;
        month = m;
        year  = y;
    }
        
    // methods
    public String toString() {
        return this.day + "." + this.month + "." + this.year + ".";
    }
    
    boolean isBefore(CalendarDate other) {
        if (this.year < other.year) { return true; }
        if (this.year > other.year) { return false; }
        // now this.year = other.year
        if (this.month < other.month) { return true; }
        if (this.month > other.month) { return false; }
        // now this.month = other.month
        if (this.day < other.day) { return true; }
        if (this.day > other.day) { return false; }
        return false;
    }
    
    public static void main(String[] args) {
        CalendarDate today = new CalendarDate(3, 4, 2024);
        System.out.println("Today is the " + today);
    }
}