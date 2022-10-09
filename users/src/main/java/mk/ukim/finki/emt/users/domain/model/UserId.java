package mk.ukim.finki.emt.users.domain.model;

import mk.ukim.finki.emt.sharedkernel.service.DomainObjectId;

public class UserId extends DomainObjectId {

    private UserId() {
        super(UserId.randomId(UserId.class).getId());
    }

    public UserId(String uuid) {
        super(uuid);
    }

    public static UserId of(String uuid) {
        return new UserId(uuid);
    }
}
