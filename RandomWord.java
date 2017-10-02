public class RandomWord {
    private String[] words = {
            "weak",
            "juice",
            "satisfying",
            "extend",
            "cooperative",
            "teeth",
            "machine",
            "unsightly",
            "throne",
            "point",
            "attempt",
            "desire",
            "river",
            "minute",
            "cars",
            "irritating",
            "cave",
            "tight",
            "acidic",
            "wine",
            "hollow",
            "alike",
            "overrated",
            "enchanted",
            "defeated",
            "better",
            "plants",
            "likeable",
            "courageous",
            "ugliest",
            "nauseating",
            "jolly",
            "pipe",
            "wide-eyed",
            "cakes",
            "stretch",
            "chief",
            "stop",
            "magenta",
            "tasty",
            "wood",
            "muscle",
            "abaft",
            "friends",
            "cluttered",
            "lavish",
            "join",
            "huge",
            "swing"
    };

    public String getRandomWord() {
        double randomNum = Math.floor(Math.random() * words.length);
        return words[(int)(randomNum)];
    }



}
