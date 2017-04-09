package twix.database;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QTwixKlienci is a Querydsl query type for TwixKlienci
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
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

    public final QTwixSLRangi ranga;

    public final NumberPath<Integer> sumaPkt = createNumber("sumaPkt", Integer.class);

    public QTwixKlienci(String variable) {
        this(TwixKlienci.class, forVariable(variable), INITS);
    }

    public QTwixKlienci(Path<? extends TwixKlienci> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTwixKlienci(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTwixKlienci(PathMetadata<?> metadata, PathInits inits) {
        this(TwixKlienci.class, metadata, inits);
    }

    public QTwixKlienci(Class<? extends TwixKlienci> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.ranga = inits.isInitialized("ranga") ? new QTwixSLRangi(forProperty("ranga")) : null;
    }

}

