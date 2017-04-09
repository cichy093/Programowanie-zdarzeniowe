package twix.database;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QTwixSLAmunicji is a Querydsl query type for TwixSLAmunicji
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTwixSLAmunicji extends EntityPathBase<TwixSLAmunicji> {

    private static final long serialVersionUID = -1545346816L;

    public static final QTwixSLAmunicji twixSLAmunicji = new QTwixSLAmunicji("twixSLAmunicji");

    public final NumberPath<Double> cena = createNumber("cena", Double.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath kaliber = createString("kaliber");

    public QTwixSLAmunicji(String variable) {
        super(TwixSLAmunicji.class, forVariable(variable));
    }

    public QTwixSLAmunicji(Path<? extends TwixSLAmunicji> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTwixSLAmunicji(PathMetadata<?> metadata) {
        super(TwixSLAmunicji.class, metadata);
    }

}

