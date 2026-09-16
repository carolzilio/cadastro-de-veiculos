import java.util.ArrayList;
import java.util.List;

public class CadastroVeiculoService {

    private final List<Veiculo> veiculos = new ArrayList<>();

    public List<Veiculo> listarTodos() {
        return new ArrayList<>(veiculos);
    }

}