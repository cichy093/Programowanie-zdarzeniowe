package twix.database.qdsl;

import static com.querydsl.core.types.PathMetadataFactory.*;
import twix.database.TwixBronAmunicja;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTwixBronAmunicja is a Querydsl query type for TwixBronAmunicja
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTwixBronAmunicja extends EntityPathBase<TwixBronAmunicja> {

    private static final long serialVersionUID = 293487790L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTwixBronAmunicja twixBronAmunicja = new QTwixBronAmunicja("twixBronAmunicja");

    protected QTwixSLAmunicji amunicja;

    protected QTwixSLBroni bron;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> idAmunicji = createNumber("idAmunicji", Integer.class);

    public final NumberPath<Integer> idBroni = createNumber("idBroni", Integer.class);

    public QTwixBronAmunicja(String variable) {
        this(TwixBronAmunicja.class, forVariable(variable), INITS);
    }

    public QTwixBronAmunicja(Path<? extends TwixBronAmunicja> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTwixBronAmunicja(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTwixBronAmunicja(PathMetadata metadata, PathInits inits) {
        this(TwixBronAmunicja.class, metadata, inits);
    }

    public QTwixBronAmunicja(Class<? extends TwixBronAmunicja> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.amunicja = inits.isInitialized("amunicja") ? new QTwixSLAmunicji(forProperty("amunicja")) : null;
        this.bron = inits.isInitialized("bron") ? new QTwixSLBroni(forProperty("bron")) : null;
    }

    public QTwixSLAmunicji amunicja() {
        if (amunicja == null) {
            amunicja = new QTwixSLAmunicji(forProperty("amunicja"));
        }
        return amunicja;
    }

    public QTwixSLBroni bron() {
        if (bron == null) {
            bron = new QTwixSLBroni(forProperty("bron"));
        }
        return bron;
    }

}

