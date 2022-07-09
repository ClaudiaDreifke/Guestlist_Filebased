import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Guestlist {

    List<String> guests = new ArrayList<>();

    public Guestlist(List<String> guests) {
        this.guests = guests;
    }

    public List<String> getGuests() {
        return guests;
    }

    public void setGuests(List<String> guests) throws IOException {
        this.guests = guests;

        String guestsString = String.join("\n",guests);
        Path path = Paths.get("guests.txt");
        Files.writeString(path,guestsString);
    }
}
