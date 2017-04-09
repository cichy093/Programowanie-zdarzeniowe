package twix.database.qdsl;

import static com.querydsl.core.types.PathMetadataFactory.*;
import twix.database.TwixRezerwacjaBroni;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTwixRezerwacjaBroni is a Querydsl query type for TwixRezerwacjaBroni
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTwixRezerwacjaBroni extends EntityPathBase<TwixRezerwacjaBroni> {

    private static final long serialVersionUID = 46236117L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTwixRezerwacjaBroni twixRezerwacjaBroni = new QTwixRezerwacjaBroni("twixRezerwacjaBroni");

    protected QTwixBronAmunicja bronAmunicja;

    public final NumberPath<Integer> idBronAmunicja = createNumber("idBronAmunicja", Integer.class);

    public final NumberPath<Integer> idRezerwacji = createNumber("idRezerwacji", Integer.class);

    protected QTwixRezerwacja rezerwacja;

    public QTwixRezerwacjaBroni(String variable) {
        this(TwixRezerwacjaBroni.class, forVariable(variable), INITS);
    }

    public QTwixRezerwacjaBroni(Path<? extends TwixRezerwacjaBroni> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTwixRezerwacjaBroni(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTwixRezerwacjaBroni(PathMetadata metadata, PathInits inits) {
        this(TwixRezerwacjaBroni.class, metadata, inits);
    }

    public QTwixRezerwacjaBroni(Class<? extends TwixRezerwacjaBroni> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.bronAmunicja = inits.isInitialized("bronAmunicja") ? new QTwixBronAmunicja(forProperty("bronAmunicja"), inits.get("bronAmunicja")) : null;
        this.rezerwacja = inits.isInitialized("rezerwacja") ? new QTwixRezerwacja(forProperty("rezerwacja"), inits.get("rezerwacja")) : null;
    }

    public QTwixBronAmunicja bronAmunicja() {
        if (bronAmunicja == null) {
            bronAmunicja = new QTwixBronAmunicja(forProperty("bronAmunicja"));
        }
        return bronAmunicja;
    }

    public QTwixRezerwacja rezerwacja() {
        if (rezerwacja == null) {
            rezerwacja = new QTwixRezerwacja(forProperty("rezerwacja"));
        }
        return rezerwacja;
    }

}

