package mk.ukim.finki.emt.users.domain.valueobjects;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.service.DomainObjectId;

public class OrderId extends DomainObjectId {

    private OrderId() {
        super(OrderId.randomId(OrderId.class).getId());
    }

    public OrderId(@NonNull String uuid) {
        super(uuid);
    }
}