import java.util.Date;


    public class Anotacao {
        private String anotacao;
        private int id;
        private Date dataCriacao;
        private Boolean removida;

        public Anotacao(int id, String anotacao) {
            this.anotacao = anotacao;
            this.id = id;
            this.dataCriacao = new Date();
            this.removida = false;
        }

        public String getAnotacao() {
            return anotacao;
        }

        @Override
        public String toString() {
            return "Anotacao{" +
                    "anotacao='" + anotacao + '\'' +
                    ", id=" + id +
                    ", dataCriacao=" + dataCriacao +
                    '}';
        }

        public void setAnotacao(String anotacao) {
            this.anotacao = anotacao;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDataCriacao() {
            return dataCriacao;
        }

        public void setDataCriacao(Date dataCriacao) {
            this.dataCriacao = dataCriacao;
        }

        public Boolean getRemovida() {
            return removida;
        }

        public void setRemovida(Boolean removida) {
            this.removida = removida;
        }
    }

