package hotel;

public class Book {
    
    private String name; 
    private String email; 
    private String checkIn; 
    private String checkOut; 
    private String guests; 
    private String roomType;
    private String rooms; 
    private String loyalty; 
    
    
    public Book() {
        super();
    }


    public Book(String name, String email, String checkIn, String checkOut, String guests, String roomType,
                String rooms, String loyalty) {
        super();
        this.name = name;
        this.email = email;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.guests = guests;
        this.roomType = roomType;
        this.rooms = rooms;
        this.loyalty = loyalty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getGuests() {
        return guests;
    }

    public void setGuests(String guests) {
        this.guests = guests;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public String getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(String loyalty) {
        this.loyalty = loyalty;
    }
}
