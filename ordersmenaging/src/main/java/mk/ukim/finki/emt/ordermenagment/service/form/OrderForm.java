package mk.ukim.finki.emt.ordermenagment.service.form;

import com.sun.istack.NotNull;
import lombok.Data;
import mk.ukim.finki.emt.sharedkernel.service.Currency;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderForm {

    @NotNull
    private Currency currency;

    private List<OrderItemForm> items = new ArrayList<>();
}
