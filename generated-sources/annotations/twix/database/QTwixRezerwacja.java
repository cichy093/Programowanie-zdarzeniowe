package twix.database;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QTwixRezerwacja is a Querydsl query type for TwixRezerwacja
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTwixRezerwacja extends EntityPathBase<TwixRezerwacja> {

    private static final long serialVersionUID = -1617489595L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTwixRezerwacja twixRezerwacja = new QTwixRezerwacja("twixRezerwacja");

    public final NumberPath<Integer> czas = createNumber("czas", Integer.class);

    public final DateTimePath<java.util.Date> data = createDateTime("data", java.util.Date.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> idKlienta = createNumber("idKlienta", Integer.class);

    public final NumberPath<Integer> idToru = createNumber("idToru", Integer.class);

    public final QTwixKlienci klient;

    public final QTwixSLTorow tor;

    public QTwixRezerwacja(String variable) {
        this(TwixRezerwacja.class, forVariable(variable), INITS);
    }

    public QTwixRezerwacja(Path<? extends TwixRezerwacja> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTwixRezerwacja(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTwixRezerwacja(PathMetadata<?> metadata, PathInits inits) {
        this(TwixRezerwacja.class, metadata, inits);
    }

    public QTwixRezerwacja(Class<? extends TwixRezerwacja> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.klient = inits.isInitialized("klient") ? new QTwixKlienci(forProperty("klient"), inits.get("klient")) : null;
        this.tor = inits.isInitialized("tor") ? new QTwixSLTorow(forProperty("tor")) : null;
    }

}

