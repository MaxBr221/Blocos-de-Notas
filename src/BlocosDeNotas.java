import java.util.ArrayList;
import java.util.List;

public class BlocosDeNotas {
    private List<Anotacao> anotacoes;
    private int contadorId;

    public BlocosDeNotas() {
        this.anotacoes = new ArrayList<>();
        this.contadorId = 1;
    }

    public String adicionarAnotacoes(String texto) throws Exception {
        if (texto == null || texto.trim().isEmpty()) {
            throw new Exception("Erro, você precisa digitar algo");
        }
        Anotacao novaAnotacao = new Anotacao(contadorId, texto);
        anotacoes.add(novaAnotacao);
        contadorId++;
        return ("Anotação adicionada com sucesso. Id: " + novaAnotacao.getId());
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

    public String removerAnotacao(int id)throws Exception {
        for (Anotacao anotacao : anotacoes) {
            if (anotacao.getId() != id && anotacao.getRemovida().equals(false)) {
                anotacao.setRemovida(false);
                throw new Exception("Erro: Anotação não encontrada ou já removida");
            }
        }
        return "Anotação removida com sucesso!";
    }

    public List<Anotacao> buscarAnotacoes(String texto)throws Exception {
        List<Anotacao> resultados = new ArrayList<>();
        for (Anotacao anotacao : anotacoes) {
            if (anotacao.getAnotacao().contains(texto) && !anotacao.getRemovida()) {
                resultados.add(anotacao);
            }
        }
        if (resultados.isEmpty()) {
            throw new Exception("ERRO, Texto não encontrado.");

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