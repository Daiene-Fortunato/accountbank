package br.com.accountbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.accountbank.enums.Flag;
import org.hibernate.Hibernate;

import javax.persistence.*;
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

    @Column(name = "name", length = 128)
    private String name;

    @Column(name = "flag", length = 45)
    @Enumerated(EnumType.STRING)
    private Flag flag;

    @ManyToOne
    @JoinColumn(name = "card_type_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_card_type_card"))
    private CardType cardType;

    @Column(name = "number", length = 20)
    private String number;

    @Column(name = "digit_code", length = 5)
    private String digitCode;

    @Column(name = "limit_balance", length = 20)
    private Double limitBalance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_card_account"))
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Account account;
    

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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	public Card(Integer id, String name, Flag flag, CardType cardType,
			String number, String digitCode, Double limitBalance,
			Account account) {
		super();
		this.id = id;
		this.name = name;
		this.flag = flag;
		this.cardType = cardType;
		this.number = number;
		this.digitCode = digitCode;
		this.limitBalance = limitBalance;
		this.account = account;
	}

	public Card() {
		super();
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