import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestGuestlist {

    @Test
    void shouldBeEmptyInitially() throws IOException {
        List<String> guests = new ArrayList<>();
        Guestlist guestlist = new Guestlist(guests);
        guestlist.setGuests(guests);
        List<String> actual = guestlist.getGuests();
        actual.isEmpty();
    }

    @Test
    void shouldReadSameGuestsAsWrittenBefore() throws IOException {
        List<String> guests = new ArrayList<>();
        Guestlist guestlist = new Guestlist(guests);
        guests.add("Karl");
        guests.add("Ute");
        guestlist.setGuests(guests);
        List<String> actual = guestlist.getGuests();
        Assertions.assertEquals(guests, actual);
    }

    @Test
    void shouldWriteToFileSystem() throws IOException {
        List<String> guests = new ArrayList<>();
        Guestlist guestlist = new Guestlist(guests);
        guests.add("Theodor");
        guests.add("Anette");
        guestlist.setGuests(guests);
        List<String> actual = Files.readAllLines(Path.of("guests.txt"));
        Assertions.assertIterableEquals(List.of("Theodor", "Anette"), actual);
    }
}
