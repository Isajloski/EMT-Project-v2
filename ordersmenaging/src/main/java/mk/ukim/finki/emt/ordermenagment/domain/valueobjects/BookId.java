package mk.ukim.finki.emt.ordermenagment.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.service.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class BookId extends DomainObjectId {


    private BookId() {
        super(BookId.randomId(BookId.class).getId());
    }

    public BookId(String uuid) {
        super(uuid);
    }


}