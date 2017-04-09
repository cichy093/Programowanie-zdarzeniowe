package twix.database;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QTwixSLRangi is a Querydsl query type for TwixSLRangi
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
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

    public QTwixSLRangi(PathMetadata<?> metadata) {
        super(TwixSLRangi.class, metadata);
    }

}

