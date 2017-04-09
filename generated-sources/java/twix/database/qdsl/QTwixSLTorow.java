package twix.database.qdsl;

import static com.querydsl.core.types.PathMetadataFactory.*;
import twix.database.TwixSLTorow;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTwixSLTorow is a Querydsl query type for TwixSLTorow
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTwixSLTorow extends EntityPathBase<TwixSLTorow> {

    private static final long serialVersionUID = -963813155L;

    public static final QTwixSLTorow twixSLTorow = new QTwixSLTorow("twixSLTorow");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath nazwa = createString("nazwa");

    public QTwixSLTorow(String variable) {
        super(TwixSLTorow.class, forVariable(variable));
    }

    public QTwixSLTorow(Path<? extends TwixSLTorow> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTwixSLTorow(PathMetadata metadata) {
        super(TwixSLTorow.class, metadata);
    }

}

