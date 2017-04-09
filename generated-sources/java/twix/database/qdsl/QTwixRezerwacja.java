package twix.database.qdsl;

import static com.querydsl.core.types.PathMetadataFactory.*;
import twix.database.TwixRezerwacja;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTwixRezerwacja is a Querydsl query type for TwixRezerwacja
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTwixRezerwacja extends EntityPathBase<TwixRezerwacja> {

    private static final long serialVersionUID = -1617489595L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTwixRezerwacja twixRezerwacja = new QTwixRezerwacja("twixRezerwacja");

    public final NumberPath<Integer> czas = createNumber("czas", Integer.class);

    public final DateTimePath<java.util.Date> data = createDateTime("data", java.util.Date.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> idKlienta = createNumber("idKlienta", Integer.class);

    public final NumberPath<Integer> idToru = createNumber("idToru", Integer.class);

    protected QTwixKlienci klient;

    protected QTwixSLTorow tor;

    public QTwixRezerwacja(String variable) {
        this(TwixRezerwacja.class, forVariable(variable), INITS);
    }

    public QTwixRezerwacja(Path<? extends TwixRezerwacja> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTwixRezerwacja(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTwixRezerwacja(PathMetadata metadata, PathInits inits) {
        this(TwixRezerwacja.class, metadata, inits);
    }

    public QTwixRezerwacja(Class<? extends TwixRezerwacja> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.klient = inits.isInitialized("klient") ? new QTwixKlienci(forProperty("klient"), inits.get("klient")) : null;
        this.tor = inits.isInitialized("tor") ? new QTwixSLTorow(forProperty("tor")) : null;
    }

    public QTwixKlienci klient() {
        if (klient == null) {
            klient = new QTwixKlienci(forProperty("klient"));
        }
        return klient;
    }

    public QTwixSLTorow tor() {
        if (tor == null) {
            tor = new QTwixSLTorow(forProperty("tor"));
        }
        return tor;
    }

}

