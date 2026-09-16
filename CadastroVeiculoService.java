import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CadastroVeiculoService {

    private static final int ANO_MINIMO = 1900;

    private final List<Veiculo> veiculos = new ArrayList<>();

    public void cadastrar(String marca, String modelo, int ano, String placa) {
        String placaNormalizada = placa == null ? "" : placa.trim().toUpperCase();

        if (placaNormalizada.isEmpty()) {
            throw new IllegalArgumentException("A placa não pode ser vazia.");
        }

        if (buscarPorPlaca(placaNormalizada) != null) {
            throw new IllegalArgumentException(
                    "Já existe um veículo cadastrado com a placa " + placaNormalizada + ".");
        }

        int anoMaximo = LocalDate.now().getYear() + 1;
        if (ano < ANO_MINIMO || ano > anoMaximo) {
            throw new IllegalArgumentException(
                    "Ano inválido. Informe um valor entre " + ANO_MINIMO + " e " + anoMaximo + ".");
        }

        veiculos.add(new Veiculo(marca, modelo, ano, placaNormalizada));
    }

    public List<Veiculo> listarTodos() {
        return new ArrayList<>(veiculos);
    }

    public Veiculo buscarPorPlaca(String placa) {
        String placaNormalizada = placa == null ? "" : placa.trim().toUpperCase();
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equalsIgnoreCase(placaNormalizada)) {
                return veiculo;
            }
        }
        return null;
    }

}