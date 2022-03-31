package br.com.accountbank.model;

import br.com.accountbank.enums.Flag;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@Table(name = "card", indexes = {
        @Index(name = "card_number_index", columnList = "number", unique = true)
})
@Entity
public class Card implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @NotNull(message = "Name is mandatory")
    @Column(name = "name", length = 128)
    private String name;
    
    @NotNull(message = "Flag is mandatory")
    @Column(name = "flag", length = 45)
    @Enumerated(EnumType.STRING)
    private Flag flag;

    @NotNull(message = "Number is mandatory")
    @Column(name = "number", length = 20, unique = true)
    private String number;

    @NotNull(message = "Digit Code is mandatory")
    @Column(name = "digit_code", length = 5)
    private String digitCode;

    @NotNull(message = "Limit Balance is mandatory")
    @Column(name = "limit_balance")
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=20, fraction=2)
    private Double limitBalance;
    
    
    //Sem o Cascade, pois ele exclui os tipos de cartão quando exclui o cartão de referencia.
    @ManyToOne
    @JoinColumn(name = "cardtype_id", referencedColumnName = "id")
    private CardType cardType;

    
    //------------- Construtor -------------------
	public Card(String name, Flag flag, String number, 
			String digitCode, Double limitBalance, CardType cardType) {
		this.name = name;
		this.flag = flag;
		this.number = number;
		this.digitCode = digitCode;
		this.limitBalance = limitBalance;
		this.cardType = cardType;
	}

	public Card() {
	}


    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Flag getFlag() {
		return flag;
	}

	public void setFlag(Flag flag) {
		this.flag = flag;
	}

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDigitCode() {
		return digitCode;
	}

	public void setDigitCode(String digitCode) {
		this.digitCode = digitCode;
	}

	public Double getLimitBalance() {
		return limitBalance;
	}

	public void setLimitBalance(Double limitBalance) {
		this.limitBalance = limitBalance;
	}
	

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Card card = (Card) o;
        return id != null && Objects.equals(id, card.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}