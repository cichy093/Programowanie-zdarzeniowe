package twix.database.qdsl;

import static com.querydsl.core.types.PathMetadataFactory.*;
import twix.database.TwixWyniki;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTwixWyniki is a Querydsl query type for TwixWyniki
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTwixWyniki extends EntityPathBase<TwixWyniki> {

    private static final long serialVersionUID = 957036868L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTwixWyniki twixWyniki = new QTwixWyniki("twixWyniki");

    public final DateTimePath<java.util.Date> data = createDateTime("data", java.util.Date.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> idKlienta = createNumber("idKlienta", Integer.class);

    protected QTwixKlienci klient;

    public final NumberPath<Integer> wynik = createNumber("wynik", Integer.class);

    public QTwixWyniki(String variable) {
        this(TwixWyniki.class, forVariable(variable), INITS);
    }

    public QTwixWyniki(Path<? extends TwixWyniki> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTwixWyniki(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTwixWyniki(PathMetadata metadata, PathInits inits) {
        this(TwixWyniki.class, metadata, inits);
    }

    public QTwixWyniki(Class<? extends TwixWyniki> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.klient = inits.isInitialized("klient") ? new QTwixKlienci(forProperty("klient"), inits.get("klient")) : null;
    }

    public QTwixKlienci klient() {
        if (klient == null) {
            klient = new QTwixKlienci(forProperty("klient"));
        }
        return klient;
    }

}

