package twix.database.qdsl;

import static com.querydsl.core.types.PathMetadataFactory.*;
import twix.database.TwixKlienci;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTwixKlienci is a Querydsl query type for TwixKlienci
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTwixKlienci extends EntityPathBase<TwixKlienci> {

    private static final long serialVersionUID = 1461316622L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTwixKlienci twixKlienci = new QTwixKlienci("twixKlienci");

    public final NumberPath<Integer> czyAdmin = createNumber("czyAdmin", Integer.class);

    public final StringPath haslo = createString("haslo");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> idRangi = createNumber("idRangi", Integer.class);

    public final StringPath imie = createString("imie");

    public final StringPath login = createString("login");

    public final StringPath nazwisko = createString("nazwisko");

    public final StringPath nrDowodu = createString("nrDowodu");

    public final StringPath pesel = createString("pesel");

    protected QTwixSLRangi ranga;

    public final NumberPath<Integer> sumaPkt = createNumber("sumaPkt", Integer.class);

    public QTwixKlienci(String variable) {
        this(TwixKlienci.class, forVariable(variable), INITS);
    }

    public QTwixKlienci(Path<? extends TwixKlienci> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTwixKlienci(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTwixKlienci(PathMetadata metadata, PathInits inits) {
        this(TwixKlienci.class, metadata, inits);
    }

    public QTwixKlienci(Class<? extends TwixKlienci> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.ranga = inits.isInitialized("ranga") ? new QTwixSLRangi(forProperty("ranga")) : null;
    }

    public QTwixSLRangi ranga() {
        if (ranga == null) {
            ranga = new QTwixSLRangi(forProperty("ranga"));
        }
        return ranga;
    }

}

