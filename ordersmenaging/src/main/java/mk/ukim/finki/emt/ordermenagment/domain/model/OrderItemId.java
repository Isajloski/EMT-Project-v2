package mk.ukim.finki.emt.ordermenagment.domain.model;


import mk.ukim.finki.emt.sharedkernel.service.DomainObjectId;

public class OrderItemId  extends DomainObjectId {

    private OrderItemId() {
        super(OrderItemId.randomId(OrderItemId.class).getId());
    }

    public OrderItemId(String uuid) {
        super(uuid);
    }
}
