package twix.database.qdsl;

import static com.querydsl.core.types.PathMetadataFactory.*;
import twix.database.TwixSLRangi;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTwixSLRangi is a Querydsl query type for TwixSLRangi
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTwixSLRangi extends EntityPathBase<TwixSLRangi> {

    private static final long serialVersionUID = -966081377L;

    public static final QTwixSLRangi twixSLRangi = new QTwixSLRangi("twixSLRangi");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath nazwa = createString("nazwa");

    public final ArrayPath<byte[], Byte> symbol = createArray("symbol", byte[].class);

    public final NumberPath<Integer> znizka = createNumber("znizka", Integer.class);

    public QTwixSLRangi(String variable) {
        super(TwixSLRangi.class, forVariable(variable));
    }

    public QTwixSLRangi(Path<? extends TwixSLRangi> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTwixSLRangi(PathMetadata metadata) {
        super(TwixSLRangi.class, metadata);
    }

}

