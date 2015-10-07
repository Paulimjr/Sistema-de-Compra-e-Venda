package model;

public class Cliente {
	private long codigo;
	private String nome;
	private String endereco;
	private String cpf;
	private String rg;
	private String cidade;
	private String bairro;
	private String estado;
	private String telefone;
        private String celular;
	private String complemento;
	private String dataDeCadastro;
        private String DataAtualizacao;
        private String numero;
        private String cep;

     public Cliente(String cpfBusca)
     {
         this.cpf = cpfBusca;
     }
     public Cliente()
     {
         
     }
     public Cliente(long cod)
     {
         this.codigo = cod;
     }
    public String getDataAtualizacao() {
        return DataAtualizacao;
    }

    public void setDataAtualizacao(String DataAtualizacao) {
        this.DataAtualizacao = DataAtualizacao;
    }

    public String getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(String dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getRg() {
		return rg;
	}


	public void setRg(String rg) {
		this.rg = rg;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
        
        
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}
        
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

    @Override
    public String toString() {
        return "codigo=" + codigo + ", nome=" + nome + ", endereco=" + endereco + ", cpf=" + cpf + ", rg=" + rg + ", cidade=" + cidade + ", bairro=" + bairro + ", estado=" + estado + ", telefone=" + telefone + ", celular=" + celular + ", complemento=" + complemento + ", dataDeCadastro=" + dataDeCadastro + ", DataAtualizacao=" + DataAtualizacao + ", numero=" + numero + ", cep=" + cep + '}';
    }
        
        
}
