package twix.database;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QTwixBronAmunicja is a Querydsl query type for TwixBronAmunicja
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTwixBronAmunicja extends EntityPathBase<TwixBronAmunicja> {

    private static final long serialVersionUID = 293487790L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTwixBronAmunicja twixBronAmunicja = new QTwixBronAmunicja("twixBronAmunicja");

    public final QTwixSLAmunicji amunicja;

    public final QTwixSLBroni bron;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> idAmunicji = createNumber("idAmunicji", Integer.class);

    public final NumberPath<Integer> idBroni = createNumber("idBroni", Integer.class);

    public QTwixBronAmunicja(String variable) {
        this(TwixBronAmunicja.class, forVariable(variable), INITS);
    }

    public QTwixBronAmunicja(Path<? extends TwixBronAmunicja> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTwixBronAmunicja(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTwixBronAmunicja(PathMetadata<?> metadata, PathInits inits) {
        this(TwixBronAmunicja.class, metadata, inits);
    }

    public QTwixBronAmunicja(Class<? extends TwixBronAmunicja> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.amunicja = inits.isInitialized("amunicja") ? new QTwixSLAmunicji(forProperty("amunicja")) : null;
        this.bron = inits.isInitialized("bron") ? new QTwixSLBroni(forProperty("bron")) : null;
    }

}

