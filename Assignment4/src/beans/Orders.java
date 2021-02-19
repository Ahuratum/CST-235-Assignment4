/**
 * 
 */
package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Nick
 *
 */

@ManagedBean(name="orders")
@ViewScoped
public class Orders {
	private List<Order> orders = new ArrayList<Order>();
	
	public Orders() {
		orders.add(new Order("17007", "USB Drive - 1GB", (float) 2.99, 1));
		orders.add(new Order("18169", "USB Drive - 2GB", (float) 3.99, 1));
		orders.add(new Order("80270", "USB Drive - 4GB", (float) 4.99, 1));
		orders.add(new Order("99014", "USB Drive - 8GB", (float) 6.99, 1));
		orders.add(new Order("34593", "USB Drive - 16GB", (float) 8.99, 1));
		orders.add(new Order("10310", "USB Drive - 32GB", (float) 11.99, 1));
		orders.add(new Order("01796", "USB Drive - 64GB", (float) 18.99, 1));
		orders.add(new Order("44590", "USB Drive - 128GB", (float) 29.99, 1));
		orders.add(new Order("36266", "USB Drive - 256GB", (float) 44.99, 1));
		orders.add(new Order("85190", "USB Drive - 512GB", (float) 59.99, 1));
		orders.add(new Order("22435", "USB Drive - 1TB", (float) 69.99, 1));
	}

	/**
	 * @return the orders
	 */
	public List<Order> getOrders() {
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
}
