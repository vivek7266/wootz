from __future__ import absolute_import
from __future__ import division
from __future__ import print_function
import tensorflow as tf

slim = tf.contrib.slim

def resnet50(data, num_classes=1000, is_training=True, reuse=None, scope='resnet50'):
	with tf.variable_scope(scope, "Model", reuse=reuse):
		with slim.arg_scope(default_arg_scope(is_training)):
			end_points = {}
			end_point = 'conv1'
			net = slim.conv2d(data, 64, [7, 7], stride=2, scope='end_point')
			end_points[end_point] = net

			end_point = 'pool1'
			net = slim.max_pool2d(net, [3, 3],stride=2, scope='end_point')
			end_points[end_point] = net

			end_point = 'res2a_branch1'
			net = slim.conv2d(net, 256, [1, 1], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res2a_branch2a'
			net = slim.conv2d(net, 64, [1, 1], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res2a_branch2b'
			net = slim.conv2d(net, 64, [3, 3], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res2a_branch2c'
			net = slim.conv2d(net, 256, [1, 1], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res2b_branch2a'
			net = slim.conv2d(net, 64, [1, 1], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res2b_branch2b'
			net = slim.conv2d(net, 64, [3, 3], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res2b_branch2c'
			net = slim.conv2d(net, 256, [1, 1], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res2c_branch2a'
			net = slim.conv2d(net, 64, [1, 1], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res2c_branch2b'
			net = slim.conv2d(net, 64, [3, 3], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res2c_branch2c'
			net = slim.conv2d(net, 256, [1, 1], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res3a_branch1'
			net = slim.conv2d(net, 512, [1, 1], stride=2, scope='end_point')
			end_points[end_point] = net

			end_point = 'res3a_branch2a'
			net = slim.conv2d(net, 128, [1, 1], stride=2, scope='end_point')
			end_points[end_point] = net

			end_point = 'res3a_branch2b'
			net = slim.conv2d(net, 128, [3, 3], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res3a_branch2c'
			net = slim.conv2d(net, 512, [1, 1], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res3b_branch2a'
			net = slim.conv2d(net, 128, [1, 1], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res3b_branch2b'
			net = slim.conv2d(net, 128, [3, 3], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res3b_branch2c'
			net = slim.conv2d(net, 512, [1, 1], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res3c_branch2a'
			net = slim.conv2d(net, 128, [1, 1], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res3c_branch2b'
			net = slim.conv2d(net, 128, [3, 3], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res3c_branch2c'
			net = slim.conv2d(net, 512, [1, 1], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res3d_branch2a'
			net = slim.conv2d(net, 128, [1, 1], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res3d_branch2b'
			net = slim.conv2d(net, 128, [3, 3], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res3d_branch2c'
			net = slim.conv2d(net, 512, [1, 1], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res4a_branch1'
			net = slim.conv2d(net, 1024, [1, 1], stride=2, scope='end_point')
			end_points[end_point] = net

			end_point = 'res4a_branch2a'
			net = slim.conv2d(net, 256, [1, 1], stride=2, scope='end_point')
			end_points[end_point] = net

			end_point = 'res4a_branch2b'
			net = slim.conv2d(net, 256, [3, 3], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res4a_branch2c'
			net = slim.conv2d(net, 1024, [1, 1], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res4b_branch2a'
			net = slim.conv2d(net, 256, [1, 1], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res4b_branch2b'
			net = slim.conv2d(net, 256, [3, 3], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res4b_branch2c'
			net = slim.conv2d(net, 1024, [1, 1], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res4c_branch2a'
			net = slim.conv2d(net, 256, [1, 1], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res4c_branch2b'
			net = slim.conv2d(net, 256, [3, 3], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res4c_branch2c'
			net = slim.conv2d(net, 1024, [1, 1], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res4d_branch2a'
			net = slim.conv2d(net, 256, [1, 1], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res4d_branch2b'
			net = slim.conv2d(net, 256, [3, 3], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res4d_branch2c'
			net = slim.conv2d(net, 1024, [1, 1], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res4e_branch2a'
			net = slim.conv2d(net, 256, [1, 1], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res4e_branch2b'
			net = slim.conv2d(net, 256, [3, 3], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res4e_branch2c'
			net = slim.conv2d(net, 1024, [1, 1], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res4f_branch2a'
			net = slim.conv2d(net, 256, [1, 1], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res4f_branch2b'
			net = slim.conv2d(net, 256, [3, 3], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res4f_branch2c'
			net = slim.conv2d(net, 1024, [1, 1], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res5a_branch1'
			net = slim.conv2d(net, 2048, [1, 1], stride=2, scope='end_point')
			end_points[end_point] = net

			end_point = 'res5a_branch2a'
			net = slim.conv2d(net, 512, [1, 1], stride=2, scope='end_point')
			end_points[end_point] = net

			end_point = 'res5a_branch2b'
			net = slim.conv2d(net, 512, [3, 3], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res5a_branch2c'
			net = slim.conv2d(net, 2048, [1, 1], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res5b_branch2a'
			net = slim.conv2d(net, 512, [1, 1], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res5b_branch2b'
			net = slim.conv2d(net, 512, [3, 3], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res5b_branch2c'
			net = slim.conv2d(net, 2048, [1, 1], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res5c_branch2a'
			net = slim.conv2d(net, 512, [1, 1], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res5c_branch2b'
			net = slim.conv2d(net, 512, [3, 3], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'res5c_branch2c'
			net = slim.conv2d(net, 2048, [1, 1], stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'pool5'
			net = slim.avg_pool2d(net, [7, 7],stride=1, scope='end_point')
			end_points[end_point] = net

			end_point = 'fc1000'
			net = slim.fully_connected(net, scope=end_point)
			end_points[end_point] = net

			end_points['prob'] = slim.softmax(net, scope='prob')


resnet50.default_image_size = 224

# The code is applicable to any model. It is adapted from 
# https://github.com/tensorflow/models/blob/master/research/slim/nets/inception_utils.py
def default_arg_scope(is_training=True, 
                       weight_decay=0.00004,
                       use_batch_norm=True,
                       batch_norm_decay=0.9997,
                       batch_norm_epsilon=0.001,
                       batch_norm_updates_collections=tf.GraphKeys.UPDATE_OPS):

   batch_norm_params = {
      # Decay for the moving averages.
      'decay': batch_norm_decay,
      # epsilon to prevent 0s in variance.
      'epsilon': batch_norm_epsilon,
      # collection containing update_ops.
      'updates_collections': batch_norm_updates_collections,
      # use fused batch norm if possible.
      'fused': None,
   }
   if use_batch_norm:
       normalizer_fn = slim.batch_norm
       normalizer_params = batch_norm_params
   else:
       normalizer_fn = None
       normalizer_params = {}

   # Set training state 
   with slim.arg_scope([slim.batch_norm, slim.dropout],
                        is_training=is_training):
       # Set weight_decay for weights in Conv and FC layers.
       with slim.arg_scope([slim.conv2d, slim.fully_connected],
                        weights_regularizer=slim.l2_regularizer(weight_decay)):
           # Set batch norm 
           with slim.arg_scope(
           [slim.conv2d],
           normalizer_fn=normalizer_fn,
           normalizer_params=normalizer_params):
               # Set default padding and stride
               with slim.arg_scope([slim.conv2d, slim.max_pool2d],
                      stride=1, padding='SAME') as sc:
                   return sc
