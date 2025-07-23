public class AnimalMain {
    public static void main(String[] args) {
        Gato gato = new Gato();
        Cachorro cachorro = new Cachorro();

        cachorro.setNome("Paçoca");

        cachorro.caminhar();
        gato.caminhar();

        cachorro.late();
        gato.mia();
    }
}
