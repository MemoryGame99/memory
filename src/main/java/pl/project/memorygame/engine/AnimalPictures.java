package pl.project.memorygame.engine;

public class AnimalPictures extends Pictures {

    private enum animalPictures {

        DOG(1),
        CAT(2),
        MOUSE(3),
        BIRD(4),
        GIRAFFE(5),
        ELEPHANT(6),
        TURTLE(7),
        SNAKE(8);

        int val;

        private animalPictures(int val) {
            this.val = val;
        }

    }
}
