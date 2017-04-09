package twix.database.qdsl;

import static com.querydsl.core.types.PathMetadataFactory.*;
import twix.database.TwixSLBroni;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTwixSLBroni is a Querydsl query type for TwixSLBroni
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTwixSLBroni extends EntityPathBase<TwixSLBroni> {

    private static final long serialVersionUID = -980350088L;

    public static final QTwixSLBroni twixSLBroni = new QTwixSLBroni("twixSLBroni");

    public final NumberPath<Double> cena = createNumber("cena", Double.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath nazwa = createString("nazwa");

    public final StringPath typ = createString("typ");

    public QTwixSLBroni(String variable) {
        super(TwixSLBroni.class, forVariable(variable));
    }

    public QTwixSLBroni(Path<? extends TwixSLBroni> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTwixSLBroni(PathMetadata metadata) {
        super(TwixSLBroni.class, metadata);
    }

}

