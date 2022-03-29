package br.com.accountbank.model;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Table(name = "account")
@Entity
public class Account implements Serializable {

	//serializable: compatibilidade para persistir e transmitir
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name_owner", length = 50)
    private String nameOwner;

    @Column(name = "agency_code", length = 4)
    private String agencyCode;

    @Column(name = "account_code", length = 8)
    private String accountCode;

    @Column(name = "digit_verification", length = 1)
    private String verificationDigit;

    @Column(name = "register_id", length = 20, unique = true)
    private String registerId;

    //Uma conta com vários cartões, sendo a entidade account a mãe das operações
  	//CascadeType.All: Propaga merge, persist, refresh e remove de account para cards
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Card> cards;    

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameOwner() {
		return nameOwner;
	}

	public void setNameOwner(String nameOwner) {
		this.nameOwner = nameOwner;
	}

	public String getAgencyCode() {
		return agencyCode;
	}

	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getVerificationDigit() {
		return verificationDigit;
	}

	public void setVerificationDigit(String verificationDigit) {
		this.verificationDigit = verificationDigit;
	}

	public String getRegisterId() {
		return registerId;
	}

	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	
	
	public Account(Integer id, String nameOwner, String agencyCode,
			String accountCode, String verificationDigit, String registerId,
			List<Card> cards) {
		super();
		this.id = id;
		this.nameOwner = nameOwner;
		this.agencyCode = agencyCode;
		this.accountCode = accountCode;
		this.verificationDigit = verificationDigit;
		this.registerId = registerId;
		this.cards = cards;
	}

	public Account() {
		super();
	}

	//Subscrição Equals: implementa relação de equivalência e relação a objetos não nulos.
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Account account = (Account) o;
        return id != null && Objects.equals(id, account.id);
    }

	//Subscrição hashCode: objetos iguais devem possuir códigos de hash iguais.
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}