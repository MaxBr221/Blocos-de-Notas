import java.util.ArrayList;
import java.util.List;

public class BlocosDeNotas {
    private List<Anotacao> anotacoes;
    private int contadorId;

    public BlocosDeNotas() {
        this.anotacoes = new ArrayList<>();
        this.contadorId = 1;
    }

    public String adicionarAnotacoes(String texto) {
        if (texto != null) {
            Anotacao novaAnotacao = new Anotacao(contadorId, texto);
            anotacoes.add(novaAnotacao);
            contadorId++;
            return "Adicionado com sucesso! ID: " + novaAnotacao.getId();
        }
        return "Erro: Texto da anotação não pode ser nulo.";
    }

    public String editarAnotacao(int id, String novoTexto) {
        for (Anotacao anotacao : anotacoes) {
            if (anotacao.getId() == id && !anotacao.getRemovida()) {
                anotacao.setAnotacao(novoTexto);
                return "Anotação editada com sucesso!";
            }
        }
        return "Erro: Anotação não encontrada!";
    }

    public String removerAnotacao(int id) {
        for (Anotacao anotacao : anotacoes) {
            if (anotacao.getId() == id && !anotacao.getRemovida()) {
                anotacao.setRemovida(true);
                return "Anotação removida com sucesso.";
            }
        }
        return "Erro: Anotação não encontrada ou já removida.";
    }

    public List<Anotacao> buscarAnotacoes(String texto) {
        List<Anotacao> resultados = new ArrayList<>();
        for (Anotacao anotacao : anotacoes) {
            if (anotacao.getAnotacao().contains(texto) && !anotacao.getRemovida()) {
                resultados.add(anotacao);
            }
        }
        return resultados;
    }

    public List<Anotacao> listarAnotacoes() {
        List<Anotacao> listaAtivas = new ArrayList<>();
        for (Anotacao anotacao : anotacoes) {
            if (!anotacao.getRemovida()) {
                listaAtivas.add(anotacao);
            }
        }
        return listaAtivas;
    }
}