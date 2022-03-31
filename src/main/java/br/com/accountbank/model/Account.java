package br.com.accountbank.model;

import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
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

    @NotNull(message = "Name Owner is mandatory")
    @Column(name = "name_owner", length = 50)
    private String nameOwner;

    @NotNull(message = "Agency Code is mandatory")
    @Column(name = "agency_code", length = 4)
    private String agencyCode;

    @NotNull(message = "Account Code is mandatory")
    @Column(name = "account_code", length = 8)
    private String accountCode;

    @NotNull(message = "Verification Digit is mandatory")
    @Column(name = "digit_verification", length = 1)
    private String verificationDigit;

    @NotNull(message = "Register Id is mandatory")
    @Column(name = "register_id", length = 20, unique = true)
    private String registerId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private List<Card> cards;


    public Account() {
        cards = new ArrayList<>();
    }

    //------- CONSTRUTOR ------------
	public Account(String nameOwner, String agencyCode,
			String accountCode, String verificationDigit, String registerId,
			List<Card> cards) {
		this.nameOwner = nameOwner;
		this.agencyCode = agencyCode;
		this.accountCode = accountCode;
		this.verificationDigit = verificationDigit;
		this.registerId = registerId;
		this.cards = cards; // == null ? new ArrayList<>() : cards;
	}

    
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


	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public List<Card> getCards() {
		return Collections.unmodifiableList(cards);
	}

	public void addCard(Card card) {
		cards.add(card);
	}

	public boolean removeCard(Card card) {
		return cards.remove(card);
	}
	

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Account account = (Account) o;
        return id != null && Objects.equals(id, account.id);
    }


    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}