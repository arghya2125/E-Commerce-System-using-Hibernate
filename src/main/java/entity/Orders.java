package entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="order_date",nullable=false)
	private Timestamp orderDate;

	@Column(name="total_amount",precision=10,scale=2,nullable=false)
	private BigDecimal totalAmount;

	//Many Orders can belong to One User
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private Users user;

	//One Order can have Many OrderDetails
	@OneToMany(mappedBy="order",
			   cascade=CascadeType.ALL)
	private List<OrderDetails> orderDetails = new ArrayList<>();

	public Orders() {
		super();
		this.id=0;
		this.orderDate=null;
		this.totalAmount=null;
		this.user=null;
	}

	public Orders(Timestamp orderDate, BigDecimal totalAmount, Users user) {
		super();
		this.orderDate=orderDate;
		this.totalAmount=totalAmount;
		this.user=user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id=id;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate=orderDate;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount=totalAmount;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user=user;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails=orderDetails;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderDate=" + orderDate
				+ ", totalAmount=" + totalAmount + "]";
	}
}
