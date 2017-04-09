package twix.database.qdsl;

import static com.querydsl.core.types.PathMetadataFactory.*;
import twix.database.TwixSLAmunicji;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTwixSLAmunicji is a Querydsl query type for TwixSLAmunicji
 */
@Generated("com.querydsl.codegen.EntitySerializer")
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

    public QTwixSLAmunicji(PathMetadata metadata) {
        super(TwixSLAmunicji.class, metadata);
    }

}

